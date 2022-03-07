public class Doctor extends Handler{
    @Override
    public String grantLoginPermission(LoginRequest loginRequest) {
        loginRequest.setAccessStatus(loginRequest.getUsername()+" Got Access For The Doctor Dashboard");
        System.out.println(loginRequest.getUsername()+" has access for doctor");
        if (loginRequest.getUserType() == UserType.DOCTOR){
            return loginRequest.getAccessStatus();
        }
        else {
            return successor.grantLoginPermission(loginRequest);
        }
    }
}
