/*
 * Copyright 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.struts.chain.commands;


import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.config.ForwardConfig;


/**
 * <p>Perform forwarding or redirection based on the specified
 * <code>ForwardConfig</code> (if any).</p>
 *
 * @author Craig R. McClanahan
 * @version $Rev$ $Date$
 */

public abstract class AbstractPerformForward extends ActionCommandBase {




    // ---------------------------------------------------------- Public Methods


    /**
     * <p>Perform forwarding or redirection based on the specified
     * <code>ActionForward</code> (if any).</p>
     *
     * @param context The <code>Context</code> for the current request
     *
     * @return <code>true</code> so that processing completes
     */
    public boolean execute(ActionContext actionCtx) throws Exception {
        // Is there a ForwardConfig to be performed?
        ForwardConfig forwardConfig = actionCtx.getForwardConfig();
        if (forwardConfig == null) {
            return (false);
        }

        // Perform the appropriate processing on this ActionForward
        perform(actionCtx, forwardConfig);
        return (true);

    }


    // ------------------------------------------------------- Protected Methods


    /**
     * <p>Perform the appropriate processing on the specified
     * <code>ForwardConfig</code>.</p>
     *
     * @param context The context for this request
     * @param forwardConfig The forward to be performed
     */
    protected abstract void perform(ActionContext context,
                                    ForwardConfig forwardConfig)
        throws Exception;


}