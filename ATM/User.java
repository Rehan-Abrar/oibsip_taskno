package ATM;

public class User {
    private String userId;
    private String pin;
    private Account account;

    public User(String userId, String pin, Account account) {
        this.userId = userId;
        this.pin = pin;
        this.account = account;
    }

    public boolean validateCredentials(String enteredId, String enteredPin) {
        return userId.equals(enteredId) && pin.equals(enteredPin);
    }

    public Account getAccount() {
        return account;
    }
}

