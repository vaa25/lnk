/**
 * Created by vaa25 on 13.06.16.
 */
public final class LinkBuilder {
    private String name = "";
    private String icon = "";
    private String path = "";
    private String exec = "";
    private String keyword = "";
    private boolean terminal = false;

    public LinkBuilder name(String name) {
        this.name = name;
        return this;
    }

    public LinkBuilder terminal(boolean terminal) {
        this.terminal = terminal;
        return this;
    }

    public LinkBuilder icon(String icon) {
        this.icon = icon;
        return this;
    }

    public LinkBuilder exec(String exec) {
        this.exec = exec;
        return this;
    }

    public LinkBuilder keyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public LinkBuilder path(String path) {
        this.path = path;
        return this;
    }

    public String build() {
        return new StringBuilder()
            .append("[Desktop Entry]\n")
            .append("Name=").append(name).append("\n")
            .append("Comment=\n")
            .append("GenericName=\n")
            .append("Keywords=").append(keyword).append("\n")
            .append("Exec=").append(exec).append("\n")
            .append("Terminal=").append(terminal).append("\n")
            .append("Type=Application\n")
            .append("Icon=").append(icon).append("\n")
            .append("Path=").append(path).append("\n")
            .append("Categories=\n")
            .append("NoDisplay=false")
            .toString();
    }
}
