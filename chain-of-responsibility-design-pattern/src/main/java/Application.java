public class Application {

    public static void main(String[] args) {

        Patient patient = new Patient();
        Pharmacist pharmacist = new Pharmacist();
        Nurse nurse = new Nurse();
        Doctor doctor = new Doctor();
        User user = new User();

        user.setSuccessor(patient);
        patient.setSuccessor(pharmacist);
        pharmacist.setSuccessor(nurse);
        nurse.setSuccessor(doctor);

        LoginRequest loginRequest = new LoginRequest("John",UserType.PATIENT);
        System.out.println(user.grantLoginPermission(loginRequest));

        LoginRequest loginRequest1 = new LoginRequest("Sawyer",UserType.PHARMACIST);
        System.out.println(user.grantLoginPermission(loginRequest1));

        LoginRequest loginRequest2 = new LoginRequest("Kate",UserType.NURSE);
        System.out.println(user.grantLoginPermission(loginRequest2));

        LoginRequest loginRequest3 = new LoginRequest("Jack",UserType.DOCTOR);
        System.out.println(user.grantLoginPermission(loginRequest3));
    }
}
