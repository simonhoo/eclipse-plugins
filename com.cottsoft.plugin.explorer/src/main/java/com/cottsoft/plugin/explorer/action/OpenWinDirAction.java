/*
 * Copyright 2005-2014 the original author or authors.
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
 * 
 * Author:	Simon.Hoo
 * Blog:   	http://www.cottsoft.com 
 * Email:	Info@cottsoft.com
 * 
 * You can @simonhoo  on Github.com, weibo.com, twitter, t.qq.com
 */

package com.cottsoft.plugin.explorer.action;

import java.io.File;
import java.io.IOException;

/**
 * Description：<br> 
 * 使用Windows UI窗口打开当前目录
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    Nov 5, 2014
 * @version v1.0.0
 */
public class OpenWinDirAction extends AbstractFileSystemResourceAction {

	@Override
	protected void doExecute(File file) {
		if (file != null) {  
            if(file.isFile()) {  
                file = file.getParentFile();  
            }  
            try {  
                Runtime.getRuntime().exec("explorer.exe " + file.getAbsolutePath());  
            } catch (IOException e) {  
                e.printStackTrace();  
            }   
        }  
	}

}


