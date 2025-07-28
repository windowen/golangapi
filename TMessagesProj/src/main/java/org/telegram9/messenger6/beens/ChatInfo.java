package org.telegram9.messenger6.beens;
public class ChatInfo {
    public long id;
    public String name;
    public String nameId;
    public int type;
    public int status;

    public ChatInfo(long id, String name, String nameId, int type, int status) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.type = type;
        this.status = status;
    }
}