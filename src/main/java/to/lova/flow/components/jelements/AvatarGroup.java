package to.lova.flow.components.jelements;

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("j-avatar-group")
@HtmlImport("bower_components/j-elements/j-avatar.html")
public class AvatarGroup extends Component {

    public AvatarGroup(Avatar... avatars) {
        this.add(avatars);
    }

    public void add(Avatar... avatars) {
        Objects.requireNonNull(avatars);
        for (Avatar avatar : avatars) {
            Objects.requireNonNull(avatar);
            this.getElement().appendChild(avatar.getElement());
        }
    }

    public void remove(Avatar... avatars) {
        Objects.requireNonNull(avatars);
        for (Avatar avatar : avatars) {
            Objects.requireNonNull(avatar);
            if (this.getElement().equals(avatar.getElement().getParent())) {
                this.getElement().removeChild(avatar.getElement());
            } else {
                throw new IllegalArgumentException("The given component ("
                        + avatar + ") is not a child of this component");
            }
        }
    }

    public void removeAll() {
        this.getElement().removeAllChildren();
    }

}
