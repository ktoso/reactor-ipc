/*
 * Copyright (c) 2011-2016 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reactor.ipc.codec.compress;

import reactor.ipc.buffer.Buffer;
import reactor.ipc.codec.Codec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Jon Brisbin
 */
public class GzipCodec<IN, OUT> extends CompressionCodec<IN, OUT> {

	public GzipCodec(Codec<Buffer, IN, OUT> delegate) {
		super(delegate);
	}

	@Override
	protected InputStream createInputStream(InputStream parent) throws IOException {
		return new GZIPInputStream(parent);
	}

	@Override
	protected OutputStream createOutputStream(OutputStream parent) throws IOException {
		return new GZIPOutputStream(parent);
	}

}
