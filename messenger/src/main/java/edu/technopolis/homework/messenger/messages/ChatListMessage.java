package edu.technopolis.homework.messenger.messages;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatListMessage extends Message {
    // получить список чатов пользователя
    // (только для залогиненных пользователей).
    // От сервера приходит список id чатов

    public ChatListMessage(long senderId) {
        super(senderId, Type.MSG_CHAT_LIST);
    }

    public ChatListMessage() {}

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof ChatListMessage))
            return false;
        return super.equals(other);
    }

    @Override
    public String toString() {
        return "ChatListMessage{" +
                super.toString() +
                "}";
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        super.writeExternal(objectOutput);

    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        super.readExternal(objectInput);
    }
}