package mymgconnect.com.mgapp.ui.profile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import io.realm.Realm;
import mymgconnect.com.mgapp.R;
import mymgconnect.com.mgapp.app.Endpoints;
import mymgconnect.com.mgapp.databinding.ActivityProfileBinding;
import mymgconnect.com.mgapp.databinding.DialogChangePasswordBinding;
import mymgconnect.com.mgapp.model.data.User;
import mymgconnect.com.mgapp.ui.profile.edit.EditProfileActivity;
import mymgconnect.com.mgapp.util.AppSettings;
import mymgconnect.com.mgapp.util.CircleTransform;


public class ProfileActivity extends MvpViewStateActivity<ProfileView, ProfilePresenter>
        implements ProfileView {

    private ActivityProfileBinding binding;
    private Realm realm;
    private User user;
    private ProgressDialog progressDialog;
    private Dialog dialog;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        realm = Realm.getDefaultInstance();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        binding.toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);


    }

    @Override
    protected void onResume() {
        super.onResume();

        user = realm.where(User.class).findFirst();
        if(user!=null) {
            // binding.setProfile(user);
            String imageURL = "";
            imageURL = Endpoints.URL_IMAGE + user.getImage();
            Log.d("TAG", imageURL);
            AppSettings appSettings = AppSettings.getAppSettingsFromSharedPreference(this);
            Glide.with(ProfileActivity.this)
                    .load(imageURL)
                    .transform(new CircleTransform(ProfileActivity.this))
                    .signature(new StringSignature(appSettings.getProfile()))
                    .error(R.drawable.placeholder_profile)
                    .into(binding.layoutHeader.imageView);

            getSupportActionBar().setTitle(user.getFullName());


            binding.setProfile(user);
            binding.setView(getMvpView());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_edit_profile:
                startActivity(new Intent(this, EditProfileActivity.class));
                return true;
            case R.id.action_edit_password:
               onChangePasswordClicked();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        user.removeChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public void onPasswordChanged() {
        if(dialog.isShowing()){
            dialog.dismiss();
            showAlert("Password Successfully Changed!");
        }
    }

    @NonNull
    @Override
    public ProfilePresenter createPresenter() {
        return new ProfilePresenter();
    }

    @NonNull
    @Override
    public ViewState<ProfileView> createViewState() {
        setRetainInstance(true);
        return new ProfileViewState();
    }

    @Override
    public void onNewViewStateInstance() {

    }


    @Override
    public void onChangePasswordClicked() {

        dialog = new Dialog(ProfileActivity.this);
        final DialogChangePasswordBinding dialogBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.dialog_change_password,
                null,
                false);
        dialogBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialogBinding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(">>>>",user.getPassword());
                presenter.changePassword(dialogBinding.etCurrPassword.getText().toString(),
                        dialogBinding.etNewPassword.getText().toString(),
                        dialogBinding.etConfirmPass.getText().toString());
            }
        });
        dialog.setContentView(dialogBinding.getRoot());
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Connecting");
        }
        progressDialog.show();
    }

    @Override
    public void stopProgress() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle(message)
                .setPositiveButton("Close", null)
                .show();
    }
}
