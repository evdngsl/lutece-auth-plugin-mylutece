/*
 * Copyright (c) 2002-2014, Mairie de Paris
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
package fr.paris.lutece.plugins.mylutece.service.security;

import fr.paris.lutece.portal.business.user.AdminUser;
import fr.paris.lutece.portal.service.datastore.DatastoreService;
import fr.paris.lutece.portal.service.security.SecurityService;
import fr.paris.lutece.portal.service.util.AppPathService;
import fr.paris.lutece.util.ReferenceItem;
import fr.paris.lutece.util.ReferenceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * This class provides public Url Service
 */
public final class AuthenticationFilterService
{
    /**
     * Session attribute that stores the LuteceUser object attached to the session
     */
    public static final String MARK_PUBLIC_LIST_URL = "public_list_url";
    public static final String PUBLIC_URL_PREFIX = "mylutece.security.public_url.";
    public static final String MARK_PORTAL_AUTHENTICATION_REQUIRED = "portal_authentication_required";
    private static final String MARK_LOCALE = "locale";
    private static final String MARK_WEBAPP_URL = "webapp_url";
    private static AuthenticationFilterService _singleton = new AuthenticationFilterService(  );

    /**
     * Private constructor
     */
    private AuthenticationFilterService(  )
    {
    }

    /**
     * Get the unique instance of the Public url Service
     * @return The instance
     */
    public static AuthenticationFilterService getInstance(  )
    {
        return _singleton;
    }

    /**
     * Build the advanced parameters management.
     *
     * @param user the current admin user
     * @param request the request
     * @return the model for the advanced parameters
     */
    public Map<String, Object> getManageAdvancedParameters( AdminUser user, HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<String, Object>(  );
        ReferenceList refListUrlPublic = DatastoreService.getDataByPrefix( PUBLIC_URL_PREFIX );

        for ( ReferenceItem refUrl : refListUrlPublic )
        {
            refUrl.setCode( refUrl.getCode(  ).replace( PUBLIC_URL_PREFIX, "" ) );
        }

        model.put( MARK_PORTAL_AUTHENTICATION_REQUIRED,
            SecurityService.getInstance(  ).isPortalAuthenticationRequired(  ) );
        model.put( MARK_PUBLIC_LIST_URL, refListUrlPublic );
        model.put( MARK_LOCALE, user.getLocale(  ) );
        model.put( MARK_WEBAPP_URL, AppPathService.getBaseUrl( request ) );

        return model;
    }

    /**
     * Gets the list of Public Urls defined in  Security service Manage Advanced Parameters
     * @return a list of Public Urls
     */
    public List<String> getPublicUrls(  )
    {
        ArrayList<String> lstPublicUrl = new ArrayList<String>(  );
        ReferenceList referenceListPublicUrl = DatastoreService.getDataByPrefix( PUBLIC_URL_PREFIX );

        if ( ( referenceListPublicUrl != null ) && !referenceListPublicUrl.isEmpty(  ) )
        {
            for ( ReferenceItem item : referenceListPublicUrl )
            {
                lstPublicUrl.add( item.getName(  ) );
            }
        }

        return lstPublicUrl;
    }
}
