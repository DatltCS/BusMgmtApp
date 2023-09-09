import React, { useRef, useState } from 'react';
import './ChatWindow.css';


import firebase from 'firebase/compat/app'; 
import 'firebase/compat/firestore';
import 'firebase/compat/auth'; 

import { useAuthState } from 'react-firebase-hooks/auth';
import { useCollectionData } from 'react-firebase-hooks/firestore';


firebase.initializeApp({
    apiKey: "AIzaSyDiMq1n0E86nefzIKaTTxIm9wRwmksnpY4",
    authDomain: "simple-chat-65c9d.firebaseapp.com",
    projectId: "simple-chat-65c9d",
    storageBucket: "simple-chat-65c9d.appspot.com",
    messagingSenderId: "110520089520",
    appId: "1:110520089520:web:02617d79105226479cf475",
    measurementId: "G-BNMEYPBE6C"
  })
  
  const auth = firebase.auth();
  const firestore = firebase.firestore();
  function App() {

    const [user] = useAuthState(auth);
  
    return (
      <div className="ChatWindow">
        <header>
          <SignOut />
        </header>
  
        <section>
          {user ? <ChatRoom /> : <SignIn />}
        </section>
  
      </div>
    );
  }
  
  function SignIn() {
  
    const signInWithGoogle = () => {
      const provider = new firebase.auth.GoogleAuthProvider();
      auth.signInWithPopup(provider);
    }
  
    return (
      <>
        <button className="sign-in" onClick={signInWithGoogle}>Sign in with Google</button>
        
      </>
    )
  
  }
  
  function SignOut() {
    return auth.currentUser && (
      <button className="sign-out" onClick={() => auth.signOut()}>Sign Out</button>
    )
  }
  
  
  function ChatRoom() {
    const dummy = useRef();
    const messagesRef = firestore.collection('messages');
    const query = messagesRef.orderBy('createdAt').limit(25);
  
    const [messages] = useCollectionData(query, { idField: 'id' });
  
    const [formValue, setFormValue] = useState('');
  
  
    const sendMessage = async (e) => {
      e.preventDefault();
  
      const { uid, photoURL } = auth.currentUser;
  
      await messagesRef.add({
        text: formValue,
        createdAt: firebase.firestore.FieldValue.serverTimestamp(),
        uid,
        photoURL
      })
  
      setFormValue('');
      dummy.current.scrollIntoView({ behavior: 'smooth' });
    }
  
    return (<>
      <main className="main-chatroom">
  
        {messages && messages.map(msg => <ChatMessage key={msg.id} message={msg} />)}
  
        <span ref={dummy}></span>
  
      </main>
  
      <form onSubmit={sendMessage} className='form-chat'>
  
        <input value={formValue} onChange={(e) => setFormValue(e.target.value)} placeholder="say something nice" className="chatbox"/>
  
        <button type="submit" disabled={!formValue} className='send'>Gửi</button>
  
      </form>
    </>)
  }
  
  
  function ChatMessage(props) {
    const { text, uid, photoURL } = props.message;
  
    const messageClass = uid === auth.currentUser.uid ? 'sent' : 'received';
  
    return (<>
      <div className={`message ${messageClass}`}>
        <img src={photoURL || 'https://api.adorable.io/avatars/23/abott@adorable.png'} className="chat-image"/>
        <p className='chat-text'>{text}</p>
      </div>
    </>)
  }
  
  
  export default App;
  