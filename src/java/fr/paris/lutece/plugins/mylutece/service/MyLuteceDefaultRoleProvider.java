/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.mylutece.service;

import fr.paris.lutece.plugins.mylutece.business.LuteceUserRoleDescription;
import fr.paris.lutece.portal.business.role.Role;
import fr.paris.lutece.portal.business.role.RoleHome;
import fr.paris.lutece.portal.service.datastore.DatastoreService;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.security.LuteceUser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * This class is used to provide default roles for myluteceusers
 */
@ApplicationScoped
@Named( "mylutece.myLuteceDefaultRoleProvider" )
public class MyLuteceDefaultRoleProvider implements IMyLuteceExternalRolesProvider
{
    // DS key
    
    private static final String PROPERTY_DEFAULT_ROLE_DESCRIPTION = "mylutece.defaultRoleProvider.roleDescription";
    private static final String PROPERTY_DEFAULT_ROLE_NOT_EXIST = "mylutece.defaultRoleProvider.roleNotExist";
    
	
	private static final String KEY_DATASTORE_DEFAULT_ROLES = "mylutece.site_property.default_role_keys";
    

    @Override
    public Collection<String> providesRoles( LuteceUser user )
    {

        String strDefaultRoleKeys = DatastoreService.getDataValue( KEY_DATASTORE_DEFAULT_ROLES, null );

        if ( strDefaultRoleKeys != null )
        {
            return Arrays.asList( strDefaultRoleKeys.split( "," ) );
        }
        else
        {
            return new ArrayList<>( );
        }
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LuteceUserRoleDescription> getLuteceUserRolesProvided(Locale locale) {
		String strDefaultRoleKeys = DatastoreService.getDataValue(KEY_DATASTORE_DEFAULT_ROLES, null);
		List<LuteceUserRoleDescription> lisDescriptions = new ArrayList<LuteceUserRoleDescription>();
		if (strDefaultRoleKeys != null) {

			for (String strRole : Arrays.asList(strDefaultRoleKeys.split(","))) {
				Role role = RoleHome.findByPrimaryKey(strRole);
				if (role != null) {
					lisDescriptions.add(
							new LuteceUserRoleDescription(role, LuteceUserRoleDescription.TYPE_AUTOMATIC_ASSIGNMENT,
									I18nService.getLocalizedString(PROPERTY_DEFAULT_ROLE_DESCRIPTION, locale)));

				} else {
					Role roleEmty = new Role();
					roleEmty.setRole(strRole);
					lisDescriptions.add(new LuteceUserRoleDescription(roleEmty,
							LuteceUserRoleDescription.TYPE_AUTOMATIC_ASSIGNMENT,
							I18nService.getLocalizedString(PROPERTY_DEFAULT_ROLE_NOT_EXIST, locale)));

				}

			}

		}
		return lisDescriptions;

	}
    
}
