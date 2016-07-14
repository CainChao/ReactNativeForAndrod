/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
    NativeModules,
    DeviceEventEmitter
} from 'react-native';
let ExampleInterface = NativeModules.ExampleInterface;
class NativeDemo extends Component {
  render() {
    return (
      <View style={styles.container}>
            <Text style={styles.welcome}
                  onPress={this.buttonPressed}>
                直接传值给原生
            </Text>
            <Text
                style={styles.welcome}
                onPress={this.buttonMethod}
              >
                回调传过去的值
            </Text>
            <Text style={styles.welcome}
                  onPress={this.buttomPromise}>
                使用Promise机制
            </Text>
      </View>
    );
  }
    buttonPressed(){
      NativeModules.ExampleInterface.HandleMessage('user','张三');
    }
    buttonMethod(){
      NativeModules.ExampleInterface.HandleMessageMethod('张三',
           (msg) => {console.log(msg);
      });
    }
  buttomPromise(){
      NativeModules.ExampleInterface.HandlePromise('张三')
          .then((msg) => {
            console.log('promiseSsucess'+msg);
          }).catch((error) =>{
            console.log('promiseError'+error);
      })
    }
  componentWillMount(){
    DeviceEventEmitter.addListener('AndroidToRNMessage',this.handleAndroidMessage);
  }
  handleAndroidMessage(aMessage){
    console.log('handleAndroidMessage'+aMessage);
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('NativeDemo', () => NativeDemo);
