package mgapp.com.mgapp.app;



public class Endpoints {

    public static final String _ID = "{id}/";

    public static final String BASE_URL = "https://mychevroletconnect.com";
    public static final String API_URL = BASE_URL+ "/api/v1/";
    public static final String IMAGE_UPLOAD = "https://api.mychevroletconnect.webstarterz.com";
    public static final String URL_IMAGE = IMAGE_UPLOAD+ "/images/";


// public static final String BASE_URL = "http://api.mychevroletconnect.webstarterz.com";
// public static final String URL_IMAGE = BASE_URL+ "/images/";
// public static final String API_URL = BASE_URL;//+ "/api/";
// public static final String IMAGE_UPLOAD = BASE_URL + "/src/v1/";


 //User
    public static final String CLIENT = "clientData";
    public static final String LOGIN = "loginClient";
    public static final String REGISTER = "registerClient";
    public static final String UPDATEUSER = "editProfile";
    public static final String UPDATEPASS = "editPassword";
    public static final String FORGOTPASS = "forgotPass";
    public static final String FIRSTLOGIN = "firstLogin";
    public static final String RESENDCODE = "resendCode";



    //Garage
    public static final String GARAGE = "garageData";
    public static final String GET_GARAGE = "allGarage";
    public static final String ADD_GARAGE = "registerGarageCar";
    public static final String UPDATE_GARAGE = "editGarage";
    public static final String DELETE_GARAGE = "deleteGarage";


    //Data
    public static final String DATA = "allData";
    public static final String GET_DEALER = "allDealer";
    public static final String GET_SERVICE = "allService";
    public static final String GET_CAR = "allCar";
    public static final String GET_PMS = "allPMS";
    public static final String GET_ADVISOR = "allAdvisor";
    public static final String GET_DEALER_CONTACTS = "allDealerContacts";
    public static final String GET_HOLIDAYS = "allHolidays";


    //Schedule
    public static final String SCHEDULE = "scheduleData";
    public static final String GET_APPOINTMENT = "allReservation";
    public static final String GET_APPOINTMENTPAST = "allPastReservation";
    public static final String GET_TIMESLOT = "daySchedule";
    public static final String RESERVE_TIMESLOT = "registerReservation";
    public static final String CANCEL_APPOINTMENT = "cancelReservation";
    public static final String RESCHED_APPOINTMENT = "reschedReservation";

    //Contact
    public static final String CONTACT_US = "contactData";
    public static final String PARTS = "parts";
    public static final String Testdrive = "testdrive";
    public static final String CONTACT = "contactus";
}