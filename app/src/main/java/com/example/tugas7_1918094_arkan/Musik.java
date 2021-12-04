package com.example.tugas7_1918094_arkan;

public class Musik {
    private String _id, _musik, _artist, _genre;
    public Musik (String id, String musik, String artist, String genre) {
        this._id = id;
        this._musik = musik;
        this._artist = artist;
        this._genre = genre;
    }
    public Musik() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_musik() {
        return _musik;
    }
    public void set_musik(String _musik) {
        this._musik = _musik;
    }
    public String get_artist() {
        return _artist;
    }
    public void set_artist(String _artist) {
        this._artist = _artist;
    }
    public String get_genre() {
        return _genre;
    }
    public void set_genre(String _genre) {
        this._genre = _genre;
    }
}

