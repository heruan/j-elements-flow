package to.lova.flow.components.jelements.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import to.lova.flow.components.jelements.Avatar;
import to.lova.flow.components.jelements.AvatarGroup;
import to.lova.flow.components.jelements.Card;

@Route("card")
@Theme(Lumo.class)
public class CardDemo extends VerticalLayout {

    public CardDemo() {
        this.setPadding(true);
        this.setSpacing(true);

        HorizontalLayout row1 = new HorizontalLayout();
        row1.setAlignItems(Alignment.START);
        row1.setSpacing(true);

        Card card1 = new Card();
        card1.setWidth("300px");
        card1.setImage("https://placeimg.com/480/320/nature");
        card1.getHeader().add(new Span("Header"));
        card1.getTitle().add(new H6("Supertitle"), new H3("Card title"),
                new H5("Subtitle for this card"));
        card1.getTitleSuffix().add(
                new Avatar("User Name", "https://placeimg.com/80/80/people"));
        card1.add(this.getParagraph(), this.getButtons());
        card1.getFooter().add(new Span("Footer"));

        Card card2 = new Card();
        card2.setWidth("300px");
        card2.getElement().getThemeList().add("image-overlay");
        card2.setImage("https://placeimg.com/481/322/nature");
        card2.setImageAspect(0.7);
        card2.getTitle().add(new H6("Supertitle"), new H3("Card title"),
                new H5("Subtitle for this card"));
        card2.getTitleSuffix().add(
                new Avatar("User Name", "https://placeimg.com/79/79/people"));
        card2.add(this.getParagraph(), this.getButtons());

        Card card3 = new Card();
        card3.setWidth("300px");
        card3.getHeader().add(new Span("Header"));
        card3.getTitle().add(new H6("Supertitle"),
                new H3("Long card title that wraps"));
        card3.getTitleSuffix().add(new AvatarGroup(new Avatar("Manny Calavera",
                "https://img00.deviantart.net/1e0a/i/2009/324/3/d/grim_fandango___manny_calavera_by_thelastangrypoet.jpg"),
                new Avatar("Guybrush Threepwood",
                        "http://www.cubed3.com/media/2011/August/jesusraz/guybrush4.jpg"),
                new Avatar("Bernard",
                        "https://orig00.deviantart.net/c955/f/2011/337/a/a/dott_bernard_icon_by_nerdsharpie-d4i0p0u.png")));
        card3.add(this.getParagraph(), this.getButtons());
        Span badge1 = new Span();
        badge1.getElement().getThemeList().addAll(
                Stream.of("badge", "error").collect(Collectors.toList()));
        badge1.add(new Icon("lumo", "bell"), new Text("Alarm"));
        card3.getFooter().add(badge1);

        row1.add(card1, card2, card3);

        HorizontalLayout row2 = new HorizontalLayout();
        row2.setAlignItems(Alignment.START);
        row2.setSpacing(true);

        Card card4 = new Card();
        card4.setWidth("300px");
        card4.setImage("https://placeimg.com/480/321/nature");

        Span badge2 = new Span();
        badge2.getElement().getThemeList()
                .addAll(Stream.of("badge", "primary", "success")
                        .collect(Collectors.toList()));
        badge2.add(new Icon("lumo", "clock"), new Text("Closing soon"));
        card4.getHeader().add(badge2);
        card4.getTitle().add(new H3("Card title"),
                new H5("Subtitle for this card"));
        card4.add(this.getParagraph());
        card4.getFooter().add(this.getButtons());

        Card card5 = new Card();
        card5.setWidth("300px");
        card5.getHeader().add(new Span("Card title"));
        card5.add(this.getParagraph(), this.getButtons());

        Card card6 = new Card();
        card6.setWidth("300px");
        card6.getTitle().add(new H3("Card title"),
                new H5("Subtitle for this card"));
        card6.add(this.getParagraph(), this.getButtons());

        row2.add(card4, card5, card6);

        this.add(row1, row2);
    }

    private Component getParagraph() {
        return new Paragraph(
                "Card content lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.");
    }

    private Component getButtons() {
        Button primaryButton = new Button("Action");
        primaryButton.getElement().getThemeList().add("primary");
        HorizontalLayout buttons = new HorizontalLayout(primaryButton,
                new Button("Action"));
        buttons.setSpacing(true);
        return buttons;
    }

}
