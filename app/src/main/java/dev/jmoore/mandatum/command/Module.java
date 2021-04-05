package dev.jmoore.mandatum.command;

public abstract class Module {
    public ModuleName moduleName;
    // todo: have permitted/denied roles/perms
    public Module(ModuleName moduleName) {
        this.moduleName = moduleName;
    }

    public static class InfoModule extends Module {
        public InfoModule() {
            super(ModuleName.Info);
        }
    }

    public enum ModuleName {
        Info, Utility, Fun, Moderation, Admin
    }
}
