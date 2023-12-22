package api.pixelPulse.pixelPulse.DTOS;

import api.pixelPulse.pixelPulse.Enum.Genres;

public record DTOUser(String userID, String email, String password, String gamesLife, Genres favoriteGenre1, Genres favoriteGenre2) {
}
