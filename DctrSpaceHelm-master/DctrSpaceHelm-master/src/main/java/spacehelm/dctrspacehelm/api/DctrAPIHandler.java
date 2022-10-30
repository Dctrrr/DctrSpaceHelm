package spacehelm.dctrspacehelm.api;

import spacehelm.dctrspacehelm.DctrSpaceHelm;

public final class DctrAPIHandler extends DctrSpaceHelm {

    public static DctrAPIHandler getInstance() {
        return (DctrAPIHandler) DctrAPIHandler.getInstance();
    }
}