/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.gohttp.header;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.message.BasicHeader;

/**
 * 接受的文件类型
 */
public class AcceptEncoding extends BasicHeader {
	public static final String NAME = "Accept-Encoding";

	public AcceptEncoding(String value) {
        super(NAME, value);
    }

    public static AcceptEncoding newDefault(){
        return new AcceptEncoding("deflate, gzip, x-gzip, identity, *;q=0");
    }

    public static AcceptEncoding fromHttpMessage(HttpMessage httpMessage){
        Header firstHeader = httpMessage.getFirstHeader(NAME);
        if(firstHeader == null){
            return null;
        }
        return new AcceptEncoding(firstHeader.getValue());
    }
}
