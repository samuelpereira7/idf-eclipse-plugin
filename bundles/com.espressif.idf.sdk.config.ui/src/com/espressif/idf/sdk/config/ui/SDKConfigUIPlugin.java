/*******************************************************************************
 * Copyright 2018-2019 Espressif Systems (Shanghai) PTE LTD. All rights reserved.
 * Use is subject to license terms.
 *******************************************************************************/
package com.espressif.idf.sdk.config.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Kondal Kolipaka <kondal.kolipaka@espressif.com>
 * 
 * The activator class controls the plug-in life cycle
 *
 */
public class SDKConfigUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.espressif.idf.sdk.config.ui"; //$NON-NLS-1$

	// The shared instance
	private static SDKConfigUIPlugin plugin;

	/**
	 * The constructor
	 */
	public SDKConfigUIPlugin() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SDKConfigUIPlugin getDefault() {
		return plugin;
	}
	
	/**
	 * @param path
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String path)
	{
		ImageDescriptor imageDescriptor = getDefault().getImageRegistry().getDescriptor(path);
		if (imageDescriptor == null)
		{
			imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, path);
			if (imageDescriptor != null)
			{
				getDefault().getImageRegistry().put(path, imageDescriptor);
			}
		}
		return imageDescriptor;
	}

	/**
	 * @param string
	 * @return
	 */
	public static Image getImage(String string)
	{
		if (getImageDescriptor(string) != null)
		{
			return getDefault().getImageRegistry().get(string);
		}
		return null;
	}

}
