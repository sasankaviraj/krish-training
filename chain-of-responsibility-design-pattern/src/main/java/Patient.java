public class Patient extends Handler{
    @Override
    public String grantLoginPermission(LoginRequest loginRequest) {
        loginRequest.setAccessStatus(loginRequest.getUsername()+" Got Access For The Patient Dashboard");
        System.out.println(loginRequest.getUsername()+" has access for patient");
        if(loginRequest.getUserType() == UserType.PATIENT){
            return loginRequest.getAccessStatus();
        }
        else {
            return successor.grantLoginPermission(loginRequest);
        }
    }
}
