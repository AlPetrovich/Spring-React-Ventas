import 'bulma/css/bulma.css';
import '@fortawesome/fontawesome-free/js/all';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import { Home } from './pages/Home';
import { Clientes } from './pages/Clientes';


function App() {

  return (
    
      <Router>
        <Switch>
            <Route exact path="/" component={ Home } />
            <Route exact path="/clientes" component={ Clientes } />
        </Switch>
      </Router>
 
  );
}

export default App;
