package edu.technopolis.homework.messenger.messages;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LoginMessage extends Message {

    // залогиниться (если логин не указан, то авторизоваться).
    // В случае успеха приходит вся инфа о пользователе
    private String login;
    private int password;

    public LoginMessage(long senderId, String login, String password) {
        super(senderId, Type.MSG_LOGIN);
        this.login = login;
        //шифрования пароля будет тут
        this.password = password.hashCode();
    }
    public LoginMessage(String login, String password) {
        this(0, login, password);
    }

    public LoginMessage() {}

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof LoginMessage))
            return false;
        if (!super.equals(other))
            return false;
        LoginMessage message = (LoginMessage) other;
        return Objects.equals(login, message.login) && Objects.equals(password, message.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                super.toString() + ", " +
                "login=" + login + ", " +
                "password='" + password + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);
        objectOutput.writeInt(password);
        objectOutput.write(login.getBytes());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        super.readExternal(objectInput);
        password = objectInput.readInt();
        login = objectInput.readLine();
    }
}