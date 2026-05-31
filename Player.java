import java.util.Objects;

public class Player {
    private int playerId;
    private String nickname;
    private GameCharacter character;

    public Player(int playerId, String nickname, GameCharacter character){
        this.playerId = playerId;
        this.nickname = nickname;
        this.character = character;
    }

    int getPlayerId(){
        return playerId;
    }
    String getNickname(){
        return nickname;
    }
    GameCharacter getCharacter(){
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerId);
    }
}
