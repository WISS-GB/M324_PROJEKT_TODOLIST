import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/ToDo Liste/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders submit button', () => {
  render(<App />);
  const submitButton = screen.getByRole('button', { name: /absenden/i });
  expect(submitButton).toBeInTheDocument();
});
