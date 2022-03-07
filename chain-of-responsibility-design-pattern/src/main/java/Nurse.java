public class Nurse extends Handler{
    @Override
    public String grantLoginPermission(LoginRequest loginRequest) {
        loginRequest.setAccessStatus(loginRequest.getUsername()+" Got Access For The Nurse Dashboard");
        System.out.println(loginRequest.getUsername()+" has access for nurse");
        if(loginRequest.getUserType() == UserType.NURSE){
            return loginRequest.getAccessStatus();
        }
        else {
            return successor.grantLoginPermission(loginRequest);
        }
    }
}
