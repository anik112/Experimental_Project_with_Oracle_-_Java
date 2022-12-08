package reportgenerator.dao;

/**
 *
 * @author Administrator
 */
public class MedicalServiceInfo {
    
    private int id;
    private String channel_service;
    private int duration_of_service;
    private int charge_for_service;
    private String service_notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel_service() {
        return channel_service;
    }

    public void setChannel_service(String channel_service) {
        this.channel_service = channel_service;
    }

    public int getDuration_of_service() {
        return duration_of_service;
    }

    public void setDuration_of_service(int duration_of_service) {
        this.duration_of_service = duration_of_service;
    }

    public int getCharge_for_service() {
        return charge_for_service;
    }

    public void setCharge_for_service(int charge_for_service) {
        this.charge_for_service = charge_for_service;
    }

    public String getService_notes() {
        return service_notes;
    }

    public void setService_notes(String service_notes) {
        this.service_notes = service_notes;
    }
    
    
    
}
