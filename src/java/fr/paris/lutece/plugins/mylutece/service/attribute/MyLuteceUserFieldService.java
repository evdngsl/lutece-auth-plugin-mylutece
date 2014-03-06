/*
 * Copyright (c) 2002-2013, Mairie de Paris
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
package fr.paris.lutece.plugins.mylutece.service.attribute;

import fr.paris.lutece.plugins.mylutece.business.attribute.AttributeHome;
import fr.paris.lutece.plugins.mylutece.business.attribute.IAttribute;
import fr.paris.lutece.plugins.mylutece.business.attribute.MyLuteceUserField;
import fr.paris.lutece.plugins.mylutece.business.attribute.MyLuteceUserFieldHome;
import fr.paris.lutece.plugins.mylutece.service.MyLutecePlugin;
import fr.paris.lutece.portal.business.user.AdminUser;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.web.constants.Messages;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * MyLuteceUserFieldService
 *
 */
public class MyLuteceUserFieldService
{
    // CONSTANTS
    private static final String CONSTANT_EMPTY_STRING = "";
    private static final String CONSTANT_UNDERSCORE = "_";

    // PARAMETERS
    private static final String PARAMETER_ATTRIBUTE = "attribute";

    private static Plugin getMyLutecePlugin(  )
    {
        return PluginService.getPlugin( MyLutecePlugin.PLUGIN_NAME );
    }

    /**
     * Check if the user fields are correctly filled
     * @param request HttpServletRequest
     * @param locale locale
     * @return null if there are no problem
     */
    public static String checkUserFields( HttpServletRequest request, Locale locale )
    {
        // Specific attributes
        List<IAttribute> listAttributes = AttributeHome.findAll( locale, getMyLutecePlugin(  ) );

        for ( IAttribute attribute : listAttributes )
        {
            String value = request.getParameter( PARAMETER_ATTRIBUTE + CONSTANT_UNDERSCORE +
                    attribute.getIdAttribute(  ) );

            if ( attribute.isMandatory(  ) && ( ( value == null ) || value.equals( CONSTANT_EMPTY_STRING ) ) )
            {
                return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
            }
        }

        return null;
    }

    /**
     * Create the user fields
     * @param nIdUser The id of the user
     * @param request HttpServletRequest
     * @param locale locale
     */
    public static void doCreateUserFields( int nIdUser, HttpServletRequest request, Locale locale )
    {
        // Attributes created in the Back-Office
        List<IAttribute> listAttributes = AttributeHome.findMyLuteceAttributes( locale, getMyLutecePlugin(  ) );

        for ( IAttribute attribute : listAttributes )
        {
            List<MyLuteceUserField> listUserFields = attribute.getUserFieldsData( request, nIdUser );

            for ( MyLuteceUserField userField : listUserFields )
            {
                if ( userField != null )
                {
                    MyLuteceUserFieldHome.create( userField, getMyLutecePlugin(  ) );
                }
            }
        }

        // Attributes associated to the plugins
        for ( MyLuteceUserFieldListenerService myLuteceUserFieldListenerService : SpringContextService.getBeansOfType( 
                MyLuteceUserFieldListenerService.class ) )
        {
            myLuteceUserFieldListenerService.doCreateUserFields( nIdUser, request, locale );
        }
    }

    /**
     * Modify the user fields
     * @param nIdUser The id of the user
     * @param request HttpServletRequest
     * @param locale locale
     * @param currentUser current user
     */
    public static void doModifyUserFields( int nIdUser, HttpServletRequest request, Locale locale, AdminUser currentUser )
    {
        // Remove all user fields
        MyLuteceUserFieldHome.removeUserFieldsFromIdUser( nIdUser, getMyLutecePlugin(  ) );

        // Attributes created in the Back-Office
        List<IAttribute> listAttributes = AttributeHome.findMyLuteceAttributes( locale, getMyLutecePlugin(  ) );

        for ( IAttribute attribute : listAttributes )
        {
            List<MyLuteceUserField> listUserFields = attribute.getUserFieldsData( request, nIdUser );

            for ( MyLuteceUserField userField : listUserFields )
            {
                if ( userField != null )
                {
                    MyLuteceUserFieldHome.create( userField, getMyLutecePlugin(  ) );
                }
            }
        }

        // Attributes associated to the plugins
        for ( MyLuteceUserFieldListenerService myLuteceUserFieldListenerService : SpringContextService.getBeansOfType( 
                MyLuteceUserFieldListenerService.class ) )
        {
            myLuteceUserFieldListenerService.doModifyUserFields( nIdUser, request, locale, currentUser );
        }
    }

    /**
     * Remove the user fields
     * @param nIdUser The id of the user
     * @param request HttpServletRequest
     * @param locale locale
     */
    public static void doRemoveUserFields( int nIdUser, HttpServletRequest request, Locale locale )
    {
        MyLuteceUserFieldHome.removeUserFieldsFromIdUser( nIdUser, getMyLutecePlugin(  ) );

        // Attributes associated to the plugins
        for ( MyLuteceUserFieldListenerService myLuteceUserFieldListenerService : SpringContextService.getBeansOfType( 
                MyLuteceUserFieldListenerService.class ) )
        {
            myLuteceUserFieldListenerService.doRemoveUserFields( nIdUser, request, locale );
        }
    }

    /**
     * Remove the user fields
     * @param nIdUser The id of the user
     * @param locale locale
     */
    public static void doRemoveUserFields( int nIdUser, Locale locale )
    {
        MyLuteceUserFieldHome.removeUserFieldsFromIdUser( nIdUser, getMyLutecePlugin(  ) );

        // Attributes associated to the plugins
        for ( MyLuteceUserFieldListenerService myLuteceUserFieldListenerService : SpringContextService.getBeansOfType( 
                MyLuteceUserFieldListenerService.class ) )
        {
            myLuteceUserFieldListenerService.doRemoveUserFields( nIdUser, locale );
        }
    }
}
