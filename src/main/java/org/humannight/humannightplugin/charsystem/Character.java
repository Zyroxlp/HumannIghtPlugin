package org.humannight.humannightplugin.charsystem;

import lombok.Getter;

import java.time.LocalDate;


public class Character {

    @Getter
    private String name;
    @Getter
    private LocalDate birthday;
    @Getter
    private String skin;
    @Getter
    private String gender;
    @Getter
    private String eyeColor;
    @Getter
    private String HairStyle;
    @Getter
    private String HairColor;
    @Getter
    private Integer id;

    public Character(String name, LocalDate birthday, String skin, String sex, String eyeColor, String hairStyle, String hairColor, Integer id) {
        this.name = name;
        this.birthday = birthday;
        this.skin = skin;
        this.gender = sex;
        this.eyeColor = eyeColor;
        HairStyle = hairStyle;
        HairColor = hairColor;
        this.id = id;

        setEyeColor("blue");
    }

    public void setName(String name){
        this.name = name;
    }
    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setSkin(String skin){
        this.skin = skin;
    }

    public void setEyeColor(String eyeColor){
        this.eyeColor = eyeColor;
    }

    public void setHairStyle(String hairStyle){
        this.HairStyle = hairStyle;
    }

    public void setHairColor(String HairColor){
        this.HairColor = HairColor;
    }

    public void setId(int id){this.id = id;}

}
