package net.dontdrinkandroot.wicket.bootstrap.component.grid;

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeLarge;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeMedium;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RowColumnTest extends AbstractWicketTest
{
    @Test
    public void bla()
    {
        RepeatingRow row = new RepeatingRow("id")
        {
            @Override
            protected void populateColumns(RepeatingView columnView)
            {
                ColumnSize columnSize = new ColumnSizeStack()
                        .setColumnSizeMedium(ColumnSizeMedium.COLUMNS_6)
                        .setColumnSizeLarge(ColumnSizeLarge.COLUMNS_3);
                for (int i = 0; i < 4; i++) {
                    int columnIdx = i;
                    Column column = new Column(columnView.newChildId())
                    {
                        @Override
                        protected Component createContent(String id)
                        {
                            return new Label(id, columnIdx);
                        }
                    };
                    column.setSize(columnSize);
                    columnView.add(column);
                }
            }
        };
        String markup = ComponentRenderer.renderComponent(row).toString();
        row.detachModels();

        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("row", tagTester.getAttribute("class"));

        tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "column");
        Assert.assertEquals("col-md-6 col-lg-3", tagTester.getAttribute("class"));
    }
}
