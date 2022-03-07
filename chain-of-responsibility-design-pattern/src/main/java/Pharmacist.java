public class Pharmacist extends Handler{
    @Override
    public String grantLoginPermission(LoginRequest loginRequest) {
        loginRequest.setAccessStatus(loginRequest.getUsername()+" Got Access For The Pharmacy Dashboard");
        System.out.println(loginRequest.getUsername()+" has access for pharmacist");
        if(loginRequest.getUserType() == UserType.PHARMACIST){
            return loginRequest.getAccessStatus();
        }
        else {
            return successor.grantLoginPermission(loginRequest);
        }
    }
}
