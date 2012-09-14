package org.terasology.rendering.gui.widgets;

import javax.vecmath.Vector2f;

import org.terasology.rendering.gui.framework.UIDisplayContainer;
import org.terasology.rendering.gui.framework.UIDisplayElement;
import org.terasology.rendering.gui.layout.Layout;

/**
 * Composition of multiple display elements which can be arranged in a specific manner by setting a layout type. Similar to the SWT composite class.
 * @author Marcel Lehwald <marcel.lehwald@googlemail.com>
 * @see org.eclipse.swt.widgets.Composite
 * 
 */
public class UIComposite extends UIDisplayContainer {
    
    private Layout compositeLayout;
    private boolean customSize = false;
    
    private void renderLayout() {
        if (compositeLayout != null) {
            compositeLayout.render();
        }
    }
    
    @Override
    public void render() {
        super.render();
        renderLayout();
    }
    
    @Override
    public void addDisplayElement(UIDisplayElement element) {
        super.addDisplayElement(element);
        
        applyLayout();
    }

    @Override
    public void addDisplayElementToPosition(int position, UIDisplayElement element) {
        super.addDisplayElementToPosition(position, element);
        
        applyLayout();
    }
    
    @Override
    public void removeDisplayElement(UIDisplayElement element) {
        super.removeDisplayElement(element);
        
        applyLayout();
    }
    
    @Override
    public void removeAllDisplayElements() {
        super.removeAllDisplayElements();
        
        applyLayout();
    }
    
    @Override
    public void setSize(String width, String height) {
        super.setSize(width, height);
        customSize = true;
    }
    
    @Override
    public void setSize(Vector2f size) {
        super.setSize(size);
        customSize = true;
    }
     
    public Layout getLayout() {
        return compositeLayout;
    }
    
    public void setLayout(Layout layout) {
        compositeLayout = layout;
    }
    
    public void applyLayout() {
        if (compositeLayout != null) {
            boolean tmp = customSize;
            compositeLayout.layout(this, !customSize);
            customSize = tmp;
        }
    }
}
