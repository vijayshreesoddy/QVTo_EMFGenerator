/*
 * generated by Xtext 2.12.0
 */
package org.eclipse.viatra.solver.language.ui;

import com.google.inject.Injector;
import org.eclipse.viatra.solver.language.ui.internal.LanguageActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SolverLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return LanguageActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return LanguageActivator.getInstance().getInjector(LanguageActivator.ORG_ECLIPSE_VIATRA_SOLVER_LANGUAGE_SOLVERLANGUAGE);
	}
	
}
