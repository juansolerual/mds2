import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-login/src/vaadin-login-form.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaIniciar_sesion extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; align-items: center; padding: var(--lumo-space-m);" id="vaadinVerticalLayout">
 <vaadin-login-form id="vaadinLoginForm"></vaadin-login-form>
 <vaadin-button style="flex-grow: 0; margin: var(--lumo-space-m);" id="loginFacebook">
   Iniciar sesión con Facebook 
 </vaadin-button>
 <vaadin-button style="flex-grow: 0; margin: var(--lumo-space-m);" id="loginGoogle">
   Iniciar sesión con Google 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-iniciar_sesion';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaIniciar_sesion.is, VistaIniciar_sesion);
