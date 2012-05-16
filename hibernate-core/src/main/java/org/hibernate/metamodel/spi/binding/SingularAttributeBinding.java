/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.spi.binding;

import java.util.List;

import org.hibernate.metamodel.spi.domain.SingularAttribute;

/**
 * Specialized binding contract for singular (non-collection) attributes
 *
 * @author Steve Ebersole
 */
public interface SingularAttributeBinding extends AttributeBinding {

	@Override
	public SingularAttribute getAttribute();

	public List<RelationalValueBinding> getRelationalValueBindings();

	/**
	 * Convenience method to determine if any {@link RelationalValueBinding simple value bindings} are derived values
	 * (formula mappings).
	 *
	 * @return {@code true} indicates that the binding contains a derived value; {@code false} indicates it does not.
	 */
	public boolean hasDerivedValue();

	/**
	 * Convenience method to determine if all {@link RelationalValueBinding simple value bindings} allow nulls.
	 *
	 * @return {@code true} indicates that all values allow {@code null}; {@code false} indicates one or more do not
	 */
	public boolean isNullable();
}