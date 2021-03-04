import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaRegistrarse extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-self: center; padding: var(--lumo-space-m); flex-direction: column; align-items: center; justify-content: flex-start;" id="vaadinVerticalLayout" theme="spacing">
 <vaadin-text-field id="nombre" style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Nombre"></vaadin-text-field>
 <vaadin-text-field style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Apellidos" id="apellidos"></vaadin-text-field>
 <vaadin-text-field style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="e-mail" id="email"></vaadin-text-field>
 <vaadin-password-field id="password" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="password"></vaadin-password-field>
 <vaadin-password-field id="password2" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" label="password2" required></vaadin-password-field>
 <vaadin-button id="registrarseButton" style="width: 100%;">
  Registrarse
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-registrarse';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaRegistrarse.is, VistaRegistrarse);
