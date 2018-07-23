package jp.kentan.minecraft.neko_core.bridge;

import me.lucko.luckperms.api.*;
import me.lucko.luckperms.api.event.EventBus;
import me.lucko.luckperms.api.manager.UserManager;

import java.util.UUID;

public class PermissionProvider {

    private final LuckPermsApi PERMS_API;

    public PermissionProvider(LuckPermsApi luckPermsApi) {
        PERMS_API = luckPermsApi;
    }

    public User getUser(UUID uuid){
        return PERMS_API.getUser(uuid);
    }

    public UserManager getUserManager() {
        return PERMS_API.getUserManager();
    }

    public EventBus getEventBus(){
        return PERMS_API.getEventBus();
    }

    public Node getNodeByGroupName(String name){
        final Group group = PERMS_API.getGroup(name);

        if(group != null){
            return PERMS_API.getNodeFactory().makeGroupNode(group).build();
        }else{
            return null;
        }
    }
}
