package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

/**
 * Behavior that manages the style of a form.
 *
 * @see FormLabelSizeBehavior
 * @see FormContainerSizeBehavior
 * @see InlineFormScreenReaderOnlyLabelBehavior
 */
public class FormStyleBehavior extends Behavior
{
    private ColumnSize containerSize;

    private boolean inline = false;

    public boolean isInline()
    {
        return this.inline;
    }

    public boolean isHorizontal()
    {
        return null != this.containerSize;
    }

    /**
     * Apply horizontal style to form. Specify the ColumnSize for the container component, the ColumnSize for the label
     * component will be computed.
     */
    public FormStyleBehavior setHorizontal(ColumnSize containerSize)
    {
        this.inline = false;
        this.containerSize = containerSize;
        return this;
    }

    public FormStyleBehavior setInline(boolean inline)
    {
        this.inline = inline;
        this.containerSize = null;
        return this;
    }

    public void reset()
    {
        this.inline = false;
        this.containerSize = null;
    }

    public ColumnSize getLabelSize()
    {
        return this.containerSize.getInverseColumnSize();
    }

    public ColumnSize getContainerSize()
    {
        return this.containerSize;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag)
    {
        super.onComponentTag(component, tag);

        if (this.isHorizontal()) {
            tag.append("class", BootstrapCssClass.FORM_HORIZONTAL.getClassString(), " ");
        }

        if (this.isInline()) {
            tag.append("class", BootstrapCssClass.FORM_INLINE.getClassString(), " ");
        }
    }
}
