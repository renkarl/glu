/*
 * Copyright (c) 2012-2013 Yan Pujante
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.linkedin.glu.agent.rest.resources
/**
 * @author yan@pongasoft.com */
public class CommandBaseResource extends BaseResource
{
  protected String commandId

  @Override
  protected void doInit() throws org.restlet.resource.ResourceException
  {
    super.doInit()
    commandId = request.getAttributes().get("id")
  }

  @Override
  def getRequestArgs()
  {
    def res = super.getRequestArgs()
    res.id = commandId
    return res
  }
}