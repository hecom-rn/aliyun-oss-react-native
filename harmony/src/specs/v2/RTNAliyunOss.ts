import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
    multipartUpload(bucketName: string, objectKey: string, uploadId: string, filepath: string, options: Object): Promise<Object>;

    initMultipartUpload(bucketName: string, objectKey: string): Promise<Object>;

    initWithSecurityToken(securityToken: string, accessKey: string, secretKey: string, endPoint: string, configuration: Object): void;

    asyncUpload(bucketName: string, objectKey: string, filepath: string, options: Object): Promise<Object>;
}

export default TurboModuleRegistry.get<Spec>(
  'RTNAliyunOss',
) as Spec | null;