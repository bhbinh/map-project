package com.example.map.model;
import jakarta.persistence.*;

@Entity
public class Location {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String description;
private double latitude;
private double longitude;

@Column(columnDefinition="TEXT")
private String polygon;

public Location(){}

public Location(Long id,String name,String description,double lat,double lng,String polygon){
this.id=id;
this.name=name;
this.description=description;
this.latitude=lat;
this.longitude=lng;
this.polygon=polygon;
}

public Long getId(){return id;}
public String getName(){return name;}
public String getDescription(){return description;}
public double getLatitude(){return latitude;}
public double getLongitude(){return longitude;}
public String getPolygon(){return polygon;}
}
