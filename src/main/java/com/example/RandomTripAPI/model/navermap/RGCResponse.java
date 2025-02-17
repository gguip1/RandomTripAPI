package com.example.RandomTripAPI.model.navermap;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RGCResponse {
    private Status status;
    private List<Results> results;

    @Setter
    @Getter
    public static class Status {
        private int code;
        private String name;
        private String message;
    }

    @Setter
    @Getter
    public static class Results {
        private String name;
        private Code code;
        private Region region;
        private Land land;
    }

    @Setter
    @Getter
    public static class Code {
        private String id;
        private String type;
        private String mappingId;
    }

    @Setter
    @Getter
    public static class Region {
        private Area area0;
        private Area area1;
        private Area area2;
        private Area area3;
        private Area area4;
    }

    @Setter
    @Getter
    public static class Area {
        private String name;
        private Coords coords;
    }

    @Setter
    @Getter
    public static class Coords {
        private Center center;
    }

    @Setter
    @Getter
    public static class Center {
        private String crs;
        private Float x;
        private Float y;
    }

    @Setter
    @Getter
    public static class Land {
        private String type;
        private String number1;
        private String number2;
        private Addition addition1;
        private Addition addition2;
        private Addition addition3;
        private Addition addition4;
        private String name;
        private Coords coords;
    }

    @Setter
    @Getter
    public static class Addition {
        private String type;
        private String value;
    }
}