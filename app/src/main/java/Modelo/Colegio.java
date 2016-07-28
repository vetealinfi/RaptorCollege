package Modelo;

/**
 * Created by CTN Developer on 28-07-2016.
 */
public class Colegio {
    private int id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String photoUrl;

    public Colegio(String name,String address,Double latitude,Double longitude) {
        this.id=0;
        this.name=name;
        this.address= address;
        this.latitude=latitude;
        this.longitude = longitude;
        this.photoUrl=null;
    }

    public Colegio(String name,String address,Double latitude,Double longitude,String photoUrl) {
        this.id=0;
        this.name=name;
        this.address= address;
        this.latitude=latitude;
        this.longitude = longitude;
        this.photoUrl=photoUrl;
    }
    public Colegio(int id,String name,String address,Double latitude,Double longitude) {
        this.id=id;
        this.name=name;
        this.address= address;
        this.latitude=latitude;
        this.longitude = longitude;
        this.photoUrl=null;
    }
    public Colegio(int id,String name,String address,Double latitude,Double longitude,String photoUrl) {
        this.id=id;
        this.name=name;
        this.address= address;
        this.latitude=latitude;
        this.longitude = longitude;
        this.photoUrl=photoUrl;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
