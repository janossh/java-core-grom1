package lesson28;

import java.util.Date;

public class Capability implements Comparable<Capability>{
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreated;

    @Override
    public int compareTo(Capability capability) {
        System.out.println("compareTo is used");
        System.out.println(""+ this.id +"-"+ capability.getId()+" = "+ (this.id - capability.getId()));
        return (int)(this.id - capability.getId());
    }

    public Capability(long id, String channelName, String fingerprint, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = fingerprint;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", ch_Name='" + channelName + '\'' +
                ", FP='" + fingerprint + '\'' +
                ", isA=" + isActive +
                ", DC=" + dateCreated +
                '}';
    }
}
