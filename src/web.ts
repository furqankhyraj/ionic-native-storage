import { WebPlugin } from '@capacitor/core';
import { DouzeNativeStoragePlugin } from './definitions';

export class DouzeNativeStorageWeb extends WebPlugin implements DouzeNativeStoragePlugin {
  constructor() {
    super({
      name: 'DouzeNativeStorage',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getContacts(filter: string): Promise<{ results: any[] }> {
    console.log('filter: ', filter)
    return {
      results: [{
        firstName: 'Dummy',
        lastName: 'entry',
        telephone: '12345',
      }]
    };
  }
}

const DouzeNativeStorage = new DouzeNativeStorageWeb();

export { DouzeNativeStorage };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(DouzeNativeStorage);
