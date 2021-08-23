declare module '@capacitor/core' {
  interface PluginRegistry {
    DouzeNativeStorage: DouzeNativeStoragePlugin;
  }
}

export interface DouzeNativeStoragePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getContacts(filter: string): Promise<{ results: any[] }>;
}
