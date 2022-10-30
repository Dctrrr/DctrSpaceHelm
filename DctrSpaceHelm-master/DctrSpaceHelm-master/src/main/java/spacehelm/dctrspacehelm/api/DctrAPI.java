package spacehelm.dctrspacehelm.api;
import org.bukkit.entity.Player;
import spacehelm.dctrspacehelm.DctrSpaceHelm;
import spacehelm.dctrspacehelm.api.DctrAPIHandler;


public final class DctrAPI {

    public static DctrSpaceHelm getAPI() {
        return DctrAPIHandler.getInstance();
    }
}