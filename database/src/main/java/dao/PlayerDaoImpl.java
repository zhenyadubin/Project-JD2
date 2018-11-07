package dao;

import model.Player;

public class PlayerDaoImpl extends BaseDaoImpl<Integer, Player> implements PlayerDao {

    private static final PlayerDaoImpl INSTANCE = new PlayerDaoImpl();

    public static PlayerDaoImpl getINSTANCE() {
        return INSTANCE;
    }

    public PlayerDaoImpl() {
        super(Player.class);
    }
}
