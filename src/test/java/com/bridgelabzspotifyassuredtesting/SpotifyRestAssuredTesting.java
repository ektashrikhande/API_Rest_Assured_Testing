package com.bridgelabzspotifyassuredtesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpotifyRestAssuredTesting {

    public String token = "Bearer BQAqtDtz3FZVyBSxuNh12ml4i6UEQ-jSgQv6XpX_Iqk_-94nSx2X_PmOedyzONvk8qr40SIvdWIzilTSqnrmiSzHeQbzZ_4x6qLq3zuUsHBqvDvfsR2x4iBf1ehg8bm4wQ9dm2qCW5qtgQsGCOZj2dYzI2IOXjC04qBvKLKxNXfzLXjAEwICDqi5g7a1ctlwt7ypCynM9-_oqLmy7LshtB-pQZ_Az7b0-fXkoYmrzmKhMZAaeEbTrJeRF0tOAMvuuNc";

    public String userID = "31qyeu7da2nhnhei2niajnyemjm4";




    @org.testng.annotations.Test
    public void GetCurrentUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        System.out.println("Current user's profile:" + userID);
        response.then().assertThat().statusCode(200);


    }

    @org.testng.annotations.Test
    public void GetUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/{user_id");
        response.prettyPrint();
        System.out.println("user's profile:" + userID);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void addItemsToPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 1)
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
        response.prettyPrint();
        System.out.println();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/smedjan/playlists?limit=10&offset=5");
        response.prettyPrint();
        System.out.println("usersPlaylist" + userID);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void createPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"New Hindi Songs\",\n" +
                        "  \"description\": \"New Playlist Hindi Songs\",\n" +
                        "  \"Public\" : false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/smedjan/playlists");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void getPlaylistItems() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlist_id}/tracks");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/tracks?market=ES&ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getTracksAudioFeatures() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getTracksAudioAnalysis() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getArtistsTopTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists//top-tracks");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getArtist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getArtistsAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists//albums");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getArtistsRelatedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists//related-artists");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getAlbumsTacks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getShowsEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows//episodes");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSeveralShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getSearchItems() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/search");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getAvailableMarkets() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

}


