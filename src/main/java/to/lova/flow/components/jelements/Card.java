/*-
 * Copyright 2017-2018 Axians SAIV S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
-*/
package to.lova.flow.components.jelements;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.server.AbstractStreamResource;

@Tag("j-card")
@HtmlImport("bower_components/j-elements/j-card.html")
public class Card extends Component
        implements FlexComponent<Card>, HasSize, HasStyle, HasSlots {

    public Card(Component... components) {
        this.add(components);
    }

    public String getImage() {
        return this.getElement().getAttribute("image");
    }

    public void setImage(String image) {
        this.getElement().setAttribute("image", image);
    }

    public void setImage(AbstractStreamResource resource) {
        this.getElement().setAttribute("image", resource);
    }

    public double getImageAspect() {
        String value = this.getElement().getAttribute("image-aspect");
        return Double.valueOf(value);
    }

    public void setImageAspect(double aspect) {
        this.getElement().setAttribute("image-aspect", String.valueOf(aspect));
    }

    public HasComponents getHeader() {
        return this.getSlot("header");
    }

    public HasComponents getFooter() {
        return this.getSlot("footer");
    }

    public HasComponents getTitle() {
        return this.getSlot("title");
    }

    public HasComponents getTitleSuffix() {
        return this.getSlot("title-suffix");
    }

}
