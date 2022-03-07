public class User extends Handler{
    @Override
    public String grantLoginPermission(LoginRequest loginRequest) {
        return successor.grantLoginPermission(loginRequest);
    }
}
